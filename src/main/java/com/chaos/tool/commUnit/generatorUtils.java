package com.chaos.tool.commUnit;

import com.chaos.tool.entity.table;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class generatorUtils {

    /**
     * 生成代码工具类
     * @param table
     * @param zos
     * @param config
     * @throws IOException
     */
    static public void generatorCode(table table, ZipOutputStream zos, Map<String, String> config) throws IOException {

        //map将表信息put进去
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", table.getTableName());
        map.put("className", table.getClassName());
        map.put("columns", table.getColumns());
        map.put("comments", table.getComments());
        map.put("package", config.get("package"));//包前缀

        //properties这类配置文件的映射。支持key-value类型和xml类型两种。继承的是map
        //加载引擎模板的资源
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //页面模板，初始化
        Velocity.init(prop);
        VelocityContext context = new VelocityContext(map);

        //模板数组
        String[] templatePaths = {
                "template/Model.java.vm"
                //,"template/Query.java.vm"
                //,"template/Dao.java.vm"
                //,"template/Mapper.xml.vm"
                //,"template/Service.java.vm"
        };

        //循环模板
        for (String path : templatePaths) {
            Template template = Velocity.getTemplate(path, "UTF-8");
            String fileName = getFileName(path, table, config);
            if (fileName == null) {
                continue;
            }
            try (StringWriter writer = new StringWriter()) {
                //替换模板的变量
                template.merge(context, writer);
                //压缩文件中的文件名称
                zos.putNextEntry(new ZipEntry(fileName));
                //写入流到zos
                IOUtils.write(writer.toString(), zos, "UTF-8");
                IOUtils.closeQuietly(writer);
                zos.closeEntry();
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static private String getFileName(String template, table table, Map<String, String> config) {
        String packagePath = config.get("package").replace(".", "/") + "/";
        String resourcesPath = config.get("resources").replace(".", "/") + "/";

        String result = null;
        if (template.contains("Model.java.vm")) {
            result = packagePath + "Model/" + table.getClassName() + ".java";
        }
        /**if (template.contains("Query.java.vm")) {
         result = packagePath + "query/" + table.getClassName() + "Query.java";
         }
         if (template.contains("Dao.java.vm")) {
         result = packagePath + "dao/" + table.getClassName() + "Dao.java";
         }
         if (template.contains("Service.java.vm")) {
         result = packagePath + "service/" + table.getClassName() + "Service.java";
         }
         if (template.contains("Mapper.xml.vm")) {
         result = resourcesPath + table.getClassName() + "Mapper.xml";
         }*/
        return result;
    }
}
