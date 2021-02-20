package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);

        List<CategoryEntity> entities1 = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0).map((menu)->{
                    menu.setChildren(getChildrens(menu,entities));
                    return menu;
                }).sorted((menu1,menu2)->{
                    return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
            }).collect(Collectors.toList());


        return entities1;
    }

    @Override
    public void removeMenuByids(List<Long> asList) {
        //TODO:检查当前删除的菜单，是否被其他地方引用
        //逻辑删除(mybatis plus 官方文档）
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> catelogPath = new ArrayList<>();
        List<Long> catelogPath1 = getCatelogPath(catelogId, catelogPath);
        Collections.reverse(catelogPath1);
        return (Long[]) catelogPath1.toArray(new Long[catelogPath1.size()]);
    }

    private List<Long> getCatelogPath(Long catelogId, List<Long> catelogPath) {
        CategoryEntity categoryEntity=this.getById(catelogId);
        catelogPath.add(catelogId);
        if (categoryEntity.getParentCid()!=0){
            getCatelogPath(categoryEntity.getParentCid(),catelogPath);
        }
        return catelogPath;
    }

    public List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter((categoryEntity -> {
            return root.getCatId() == categoryEntity.getParentCid();
        })).map((categoryEntity) -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }
}