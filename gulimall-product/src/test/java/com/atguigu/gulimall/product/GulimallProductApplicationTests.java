package com.atguigu.gulimall.product;


import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
//
//    @Autowired
//    private OSSClient ossClient;

    @Test
    void testUpload(){
//        // 创建PutObjectRequest对象。
//        PutObjectRequest putObjectRequest = new PutObjectRequest("gulimall-niuxiaotong", "华为3", new File("/Users/niuxiaotong/Desktop/谷粒/谷粒商城-github/pic/华为3.jpg"));
//
//        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
//        // ObjectMetadata metadata = new ObjectMetadata();
//        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//        // metadata.setObjectAcl(CannedAccessControlList.Private);
//        // putObjectRequest.setMetadata(metadata);
//
//        // 上传文件。
//        ossClient.putObject(putObjectRequest);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
    }

    @Test
    void contextLoads() {
//        BrandEntity brandEntity=new BrandEntity();
////        brandEntity.setName("华为");
////        brandService.save(brandEntity);
////        System.out.println("保存成功");
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("华为哈哈哈");
//        brandService.updateById(brandEntity);

        List<BrandEntity> brand_id = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        brand_id.forEach((item)->{
            System.out.println(item);
        });


    }

}
