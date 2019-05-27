package leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import leyou.common.enums.ExceptionEnum;
import leyou.common.exception.LyException;
import leyou.common.vo.PageResult;
import leyou.item.mapper.SpuDetailMapper;
import leyou.item.mapper.SpuMapper;
import leyou.item.pojo.Spu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class GoodsService {
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper detailMapper;

    public PageResult<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key) {
        //分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        //搜索字段过滤
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("title","%"+key+"%");
        }
        //上下架过滤
        if(saleable != null){
            criteria.andEqualTo("saleable",saleable);
        }

        //默认排序
        example.setOrderByClause("lastUpdateTime DESC");

        //查询
        List<Spu> spus = spuMapper.selectByExample(example);
        //判断
        if(CollectionUtils.isEmpty(spus)){
            throw new LyException(ExceptionEnum.GOODS_NOT_FOUND);
        }
        //解析分类和品牌的名称
        loadCategoryAndBrandName(spus);
        //解析分页结果
        PageInfo<Spu> info = new PageInfo<>(spus);
        return new PageResult<>(info.getTotal(),spus);
    }

    private void loadCategoryAndBrandName(List<Spu> spus) {
        for (Spu spu: spus){
            //处理分类名称
            spu.g
            //处理品牌名称
        }
    }
}
