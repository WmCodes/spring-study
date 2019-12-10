package xyz.drafter.cap1.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
public class SpringTypeFilter implements TypeFilter {


    /**  
     *    
     *   
     * @author drafter 
     * @date 2019/12/4 10:39  
     * @param [metadataReader, metadataReaderFactory]  
     * @return boolean  
     * @Instructions  metadataReader 读取到当前正在扫描的类
     *                metadataReaderFactory 可以获取到其他任何类信息
     */  
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源(类路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("------> "+className);
        if (className.contains("order")){
            return true;
        }
        return false;
    }

    
}
