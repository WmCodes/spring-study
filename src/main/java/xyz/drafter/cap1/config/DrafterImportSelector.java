package xyz.drafter.cap1.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author drafter
 * @date 2019/12/4
 * @desciption
 */
public class DrafterImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 返回全类
        return new String[]{"xyz.drafter.cap1.bean.Fish","xyz.drafter.cap1.bean.Tiger"};
    }
}
