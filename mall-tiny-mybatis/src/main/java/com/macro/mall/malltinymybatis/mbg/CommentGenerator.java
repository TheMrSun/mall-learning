package com.macro.mall.malltinymybatis.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义注释生成器
 *
 * @author Slience
 * @version 1.0
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;

    /**
     * 设置用户配置参数
     *
     * @param properties generatorConfig.xml CommentGenerator 对应的配置 properties
     *                   DefaultCommentGenerator properties 默认值均为 false
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * 字段添加注释
     *
     * @param field  字段
     * @param introspectedTable 表
     * @param introspectedColumn 列
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remark = introspectedColumn.getRemarks();
        //根据参数判断是否添加备注信息
        if (addRemarkComments && StringUtility.stringHasValue(remark)) {
            addFieldJavaDoc(field,remark);
        }
    }

    /**
     * model 字段添加注释
     * @param field 字段
     * @param remark 备注
     */
    private void addFieldJavaDoc(Field field, String remark) {
        field.addJavaDocLine("/**");
        //读取数据库字段的备注信息
        String[] remarkLinks = remark.split(System.getProperty("line.separator"));
        for(String remarkLink : remarkLinks){
            field.addJavaDocLine(" *" + remarkLink);
        }
        addJavadocTag(field,false);
        field.addJavaDocLine(" */");
    }
}
