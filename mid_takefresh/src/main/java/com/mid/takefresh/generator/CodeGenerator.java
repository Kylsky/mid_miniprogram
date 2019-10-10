package com.mid.takefresh.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.*;

/**
 * <p>
 * 代码生成器父类
 * </p>
 *
 * @author Caratacus
 */
public class CodeGenerator {


    public static void main(String[] args) {
        String tableName="take_fresh_commit";
        // 代码生成器
        AutoGenerator mpg = getAutoGenerator(tableName);
        mpg.execute();
        if (tableName == null) {
            System.err.println(" Generator Success !");
        } else {
            System.err.println(" TableName【 " + tableName + " 】" + "Generator Success !");
        }
    }

    /**
     * 获取TemplateConfig
     *
     * @return
     */
    protected static TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null).setEntity(null);
    }

    /**
     * 获取InjectionConfig
     *
     * @return
     */
    protected static InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        }.setFileOutConfigList(getFileOutConfigList());
    }

    /**
     * 获取PackageConfig
     *
     * @return
     */
    protected static PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent("")
                .setController("com.mid.takefresh.rest")
                .setEntity("com.mid.api.takefresh.entity")
                .setMapper("com.mid.takefresh.mapper")
                .setService("com.mid.takefresh.service")
                .setServiceImpl("com.mid.takefresh.service.impl");
    }

    /**
     * 获取StrategyConfig
     *
     * @param tableName
     * @return
     */
    protected static StrategyConfig getStrategyConfig(String tableName) {
        return new StrategyConfig()
                .setCapitalMode(false)// 全局大写命名
                .setTablePrefix("mid_")// 去除前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                //.setInclude(new String[] { "user" }) // 需要生成的表
                //自定义实体父类
                //.setSuperEntityClass("org.crown.framework.model.BaseModel")
                // 自定义实体，公共字段
                //.setSuperEntityColumns("id")
                // 自定义 mapper 父类
                .setSuperMapperClass("com.mid.takefresh.common.SuperMapper")
                // 自定义 service 实现类父类
                .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl")
                // 自定义 service 接口父类
                .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")
                // 【实体】是否生成字段常量（默认 false）
                //.setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                //.setEntityBuilderModel(false)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                //.setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setInclude(tableName);
    }

    /**
     * 获取DataSourceConfig
     *
     * @return
     */
    protected static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)// 数据库类型
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        if (fieldType.toLowerCase().equals("bit")) {
                            return DbColumnType.INTEGER;
                        }
                        if (fieldType.toLowerCase().equals("tinyint")) {
                            return DbColumnType.BOOLEAN;
                        }
                        if (fieldType.toLowerCase().equals("date")) {
                            return DbColumnType.LOCAL_DATE;
                        }
                        if (fieldType.toLowerCase().equals("time")) {
                            return DbColumnType.LOCAL_TIME;
                        }
                        if (fieldType.toLowerCase().equals("datetime")) {
                            return DbColumnType.LOCAL_DATE_TIME;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                })
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("mid_takefresh")
                .setPassword("mid413a")
                .setUrl("jdbc:mysql://119.23.64.10:3306/mid_takefresh?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8");
    }

    /**
     * 获取GlobalConfig
     *
     * @return
     */
    protected static GlobalConfig getGlobalConfig() {
        return new GlobalConfig()
                .setOutputDir(getJavaPath())//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(false)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(false)// XML ResultMap
                .setBaseColumnList(false)// XML columList
                .setKotlin(false) //是否生成 kotlin 代码
                .setOpen(false)
                .setAuthor("kongyilei") //作者
                //自定义文件命名，注意 %s 会自动填充表实体属性！
                .setEntityName("%s")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sRestController");
    }


    /**
     * 获取根目录
     *
     * @return
     */
    private static String getRootPath() {
        String file = Objects.requireNonNull(CodeGenerator.class.getClassLoader().getResource("")).getFile();
        return new File(file).getParentFile().getParent();
    }

    /**
     * 获取JAVA目录
     *
     * @return
     */
    protected static String getJavaPath() {
        String javaPath = getRootPath() + "/src/main/java";
        System.err.println(" Generator Java Path:【 " + javaPath + " 】");
        return javaPath;
    }

    /**
     * 获取Resource目录
     *
     * @return
     */
    protected String getResourcePath() {
        String resourcePath = getRootPath() + "/src/main/resources";
        System.err.println(" Generator Resource Path:【 " + resourcePath + " 】");
        return resourcePath;
    }

    /**
     * 获取AutoGenerator
     *
     * @param tableName
     * @return
     */
    protected static AutoGenerator getAutoGenerator(String tableName) {
        return new AutoGenerator()
                // 全局配置
                .setGlobalConfig(getGlobalConfig())
                // 数据源配置
                .setDataSource(getDataSourceConfig())
                // 策略配置
                .setStrategy(getStrategyConfig(tableName))
                // 包配置
                .setPackageInfo(getPackageConfig())
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                .setCfg(getInjectionConfig())
                .setTemplate(getTemplateConfig());
    }

    protected static List<FileOutConfig> getFileOutConfigList(){
        // 自定义 entity 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "D:\\project\\IDEA project\\mid_miniprogram\\mid_api\\src\\main\\java\\com\\mid\\api\\takefresh\\entity" + tableInfo.getEntityName() + "Entity.java";
            }
        });

        // 调整 mapper 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D:\\project\\IDEA project\\mid_miniprogram\\mid_takefresh\\src\\main\\resources\\mapper" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        return focList;
    }

}
