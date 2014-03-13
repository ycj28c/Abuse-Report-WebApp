package tools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * can generate vo class automaticly in mysql database
 */
public class AutoGenerateVO{
        private String DRIVER ;
        private String URL ;
        private String USERNAME ;
        private String PASSWORD ;
        private Connection CONN;
        private Statement STMT;
        private ResultSet RESULTSET;
        private String pojoFilePath;
        private String packageName;
        public AutoGenerateVO(){}
        public AutoGenerateVO(String DRIVER,String URL,String USERNAME,String PASSWORD){
            this.DRIVER = DRIVER;
            this.URL = URL;
            this.USERNAME = USERNAME;
            this.PASSWORD = PASSWORD;
        }
        private void createConnection(){
            try {
                Class.forName(DRIVER);
                CONN = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if(CONN == null){
                    throw new RuntimeException("获取数据库连接错误");
                }else{
                    STMT = CONN.createStatement();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void createPOJO(){
            try {
                //获取数据库连接
                createConnection();
                DatabaseMetaData database = CONN.getMetaData();
                List<Object> tables = new ArrayList<Object>();
                String[] types = {"TABLE"};
                //获取所有的表名
                RESULTSET = database.getTables(null, null, null, types);
                while(RESULTSET.next()){
                    tables.add(RESULTSET.getObject("TABLE_NAME"));
                }
                List<Map<String, Object>> tableList = new ArrayList<Map<String, Object>>();
                for(Object tableName : tables){
                    Map<String, Object> table = new HashMap<String, Object>();
                    List<Map<String, Object>> columnList = new ArrayList<Map<String, Object>>();
                    String sql = "select * from `" + tableName.toString()+"` limit 0,0;" ;
                    System.out.println(sql);
                    PreparedStatement preStmt = CONN.prepareStatement(sql);
                    ResultSet resultSet = preStmt.executeQuery();
                    ResultSetMetaData rsmd = resultSet.getMetaData();
                    int tableLength = rsmd.getColumnCount();
                    System.out.println(tableLength);
                    for (int i = 1; i <= tableLength; i++) {
                        Map<String, Object> column = new HashMap<String, Object>();
                        String columnType = rsmd.getColumnTypeName(i);
                        String columnTypeClass = rsmd.getColumnClassName(i);  
                        String columnName = rsmd.getColumnName(i);  
                        int columnLength = rsmd.getColumnDisplaySize(i);
                        column.put("columnType", columnType);
                        if(checkIsCharArray(columnType, columnTypeClass)){
                            column.put("columnTypeClass", "java.lang.Character[]");
                        }else{
                            column.put("columnTypeClass", columnTypeClass);
                        }
                        column.put("columnName", columnName);
                        column.put("columnLength", columnLength);
                        columnList.add(column);
                    }
                    table.put("tableName", tableName);
                    table.put("columns", columnList);
                    tableList.add(table);
                }
                analysisTableList(tableList);
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                closeDBConnection(CONN,STMT,RESULTSET);
            }
        }
        /**
         * 解析TableList
         * @param tableList
         * @throws Exception 
         */
        private void analysisTableList(List<Map<String, Object>> tableList) throws Exception{
            for (Map<String, Object> map : tableList) {
                String tableName = (String) map.get("tableName");
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> columnList = (List<Map<String, Object>>) map.get("columns");
                createSingleTableString(tableName,columnList);
            }
        }
        /**
         * 根据单个表，生成单个文件的字符序列
         * @param tableName
         * @param columnList
         * @throws Exception
         */
        private void createSingleTableString(String tableName,List<Map<String, Object>> columnList) throws Exception{
            //文件名
            String fileName = getFileName(tableName);
            //文件内容
            StringBuilder tableFileString = new StringBuilder();
            //设置包名
            tableFileString.append("package "+getPackageName()+" ; \n\r");
            //导入包
            tableFileString.append(createImportPackageString(columnList));
            tableFileString.append("\n\r");
            // public class
            tableFileString.append(getClassString(tableName)+" { \n\r\n\r");
            List<Map<String, String>> columnNameAndTypeList = buildcolumnNameAndType(columnList);
            for(Map<String, String> map : columnNameAndTypeList){
                String propertyString = getPropertyString(map.get("columnName"),map.get("columnType"));
                tableFileString.append("    ");
                tableFileString.append(propertyString);
                tableFileString.append(" ;\n");
            }
            tableFileString.append("\n\r");
            for(Map<String, String> map : columnNameAndTypeList){
                String getSetString = buildGetAndSetMethod(map.get("columnName"),map.get("columnType"));
                tableFileString.append(getSetString);
            }
            tableFileString.append("}");
            String filePath = getPojoFilePath();
            if(null == filePath || "".equals(filePath)){
                filePath = "d:/pojos";
            }
            createFile(filePath,fileName,tableFileString.toString());
        }
        private String createImportPackageString(List<Map<String, Object>> columnList){
            StringBuilder builder = new StringBuilder();
            //导入所需要的包
            List<String> importStringList = new ArrayList<String>();
            for (Map<String, Object> map : columnList) {
                String columnTypeClass = map.get("columnTypeClass").toString();
                if(!columnTypeClass.startsWith("java.lang")){
                    String importString = "import "+columnTypeClass+" ; \n\r";
                    if(!importStringList.contains(importString)){
                        importStringList.add(importString);
                    }
                }
            }
            for(String str : importStringList){
                builder.append(str);
            }
            return builder.toString();
        }
        /**
         * 生成get  set  方法
         * @param columnName
         * @param columnType
         * @return
         */
        private String buildGetAndSetMethod(String columnName, String columnType) {
            StringBuilder builder = new StringBuilder();
            String columnNameUpper = columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
            builder.append("    public "+columnType+" get"+columnNameUpper+"() {\n");
            builder.append("        return this."+columnName+";\n");
            builder.append("    }\n\r");
            builder.append("    public void set"+columnNameUpper+"("+columnType+" "+columnName+") { \n");
            builder.append("        this."+columnName+" = "+columnName+";\n");
            builder.append("    }\n\r");
            return builder.toString();
        }
        /**
         * 生成column名字和类型的对应
         * @param columnList
         * @return
         */
        private List<Map<String, String>> buildcolumnNameAndType(List<Map<String, Object>> columnList) {
            List<Map<String, String>> columnNameAndTypeList = new ArrayList<Map<String, String>>();
            for (Map<String, Object> column : columnList) {
                String propertyName = column.get("columnName").toString();
                String propertyType = column.get("columnTypeClass").toString();
                if(propertyName.startsWith("c_")){
                    propertyName.substring(2);
                }
                String[] nameArray = propertyName.split("_");
                StringBuilder propertyNameResult = new StringBuilder();
                for (int i = 0; i < nameArray.length; i++) {
                    String str = nameArray[i];
                    if(i == 0){
                        propertyNameResult.append(str.toLowerCase());
                    }else{
                        propertyNameResult.append(str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase());
                    }
                }
                Map<String, String> map = new HashMap<String, String>();
                map.put("columnName", propertyNameResult.toString());
                String columnType = column.get("columnTypeClass").toString();
                int startNum = columnType.lastIndexOf(".");
                map.put("columnType", propertyType.substring(startNum+1));
                columnNameAndTypeList.add(map);
            }
            return columnNameAndTypeList;
        }
        /**
         * 生成文件名
         * @param tableName
         * @return
         */
        private String getFileName(String tableName){
            if(tableName.startsWith("t_")){
                tableName = tableName.substring(2);
            }
            String[] nameArray = tableName.split("_");
            StringBuilder result = new StringBuilder();
            for(String str : nameArray){
                result.append(str.substring(0, 1).toUpperCase()+str.substring(1));
            }
            result.append(".java");
            return result.toString();
        }
        /**
         * 生成类字符串
         * 表的名字有三种形式  例如：
         * 1.t_user
         * 2.user
         * 3.t_user_info
         * @param tableName
         * @return
         */
        private String getClassString(String tableName){
            if(tableName.startsWith("t_")){
                tableName = tableName.substring(2);
            }
            String[] nameArray = tableName.split("_");
            StringBuilder result = new StringBuilder();
            result.append("public class ");
            for(String str : nameArray){
                result.append(str.substring(0, 1).toUpperCase()+str.substring(1));
            }
            return result.toString();
        }
        /**
         * 生成属性字符串
         * 属性的名字有三种形式  例如：
         * 1.c_username
         * 2.username
         * 3.c_user_name
         * @param tableName
         * @return
         */
        private String getPropertyString(String propertyName,String propertyType){
            StringBuilder result = new StringBuilder();
            result.append("private "+propertyType+" ");
            result.append(propertyName);
            return result.toString();
        }
        /**
         * 生成文件
         * @param filePath
         * @param fileName
         * @throws Exception
         */
        private void createFile(String filePath,String fileName,String fileContent) throws Exception{
            File file = new File(filePath, fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStream out = new FileOutputStream(file);
            byte[] b = fileContent.getBytes();
            out.write(b);
            out.flush();
            out.close();
        }
        /**
         * 判断数据类型
         * @param sqlType
         * @param classType
         * @return
         */
        public Boolean checkIsCharArray(String sqlType,String classType){
            List<String> sqlExcludeTypeList = new ArrayList<String>();
            sqlExcludeTypeList.add("BIT");
            sqlExcludeTypeList.add("BLOB");
            sqlExcludeTypeList.add("LONGBLOB");
            sqlExcludeTypeList.add("MEDIUMBLOB");
            sqlExcludeTypeList.add("TINYBLOB");
            sqlExcludeTypeList.add("BINARY");
            sqlExcludeTypeList.add("VARBINARY");
            if(sqlExcludeTypeList.contains(sqlType) && classType.equals("[B")){
                return true;
            }else{
                return false;
            }
        }
        /**
         * 关闭数据库连接
         * @param conn
         * @param stmt
         * @param resultSet
         */
        private void closeDBConnection(Connection conn,Statement stmt,ResultSet resultSet){
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally{
                    if(stmt != null){
                        try {
                            stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally{
                            if(conn != null){
                                try {
                                    conn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        //get  set  初始化数据
        public String getDRIVER() {
            return DRIVER;
        }
        public void setDRIVER(String DRIVER) {
            this.DRIVER = DRIVER;
        }
        public String getURL() {
            return URL;
        }
        public void setURL(String URL) {
            this.URL = URL;
        }
        public String getUSERNAME() {
            return USERNAME;
        }
        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }
        public String getPASSWORD() {
            return PASSWORD;
        }
        public void setPASSWORD(String PASSWORD) {
            this.PASSWORD = PASSWORD;
        }
        public String getPojoFilePath() {
            return pojoFilePath;
        }
        public void setPojoFilePath(String pojoFilePath) {
            this.pojoFilePath = pojoFilePath;
        }
        public String getPackageName() {
            return packageName;
        }
        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }
}
