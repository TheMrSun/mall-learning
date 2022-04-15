package com.macro.mall.malltinymybatis.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 生产mbg代码
 * @author Slience
 * @version 1.0
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //MBG 执行过程中的警告信息
        List<String> warnings = new ArrayList<>();
        //代码重复时，是否进行覆盖
        boolean overwrite = false;
        //读取MBG 配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        //创建配置解析器
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        //shellCallback 接口用来处理文件的创建和合并，传入overwrite参数
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //执行创建代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for(String warning : warnings){
            System.out.println(warning);
        }
    }

}
