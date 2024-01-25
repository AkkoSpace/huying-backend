package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.common.ErrorCode;
import space.akko.springbootinit.exception.BusinessException;
import space.akko.springbootinit.mapper.BasicProductSellingPriceMapper;
import space.akko.springbootinit.model.domain.BasicProduct;
import space.akko.springbootinit.model.domain.BasicProductSellingPrice;
import space.akko.springbootinit.model.vo.BasicProductSellingPriceVO;
import space.akko.springbootinit.service.BasicProductSellingPriceService;
import space.akko.springbootinit.service.BasicProductService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【basic_product_selling_price(产品销售价格表)】的数据库操作Service实现
 * @createDate 2024-01-08 10:21:52
 */
@Service
public class BasicProductSellingPriceServiceImpl extends ServiceImpl<BasicProductSellingPriceMapper, BasicProductSellingPrice>
        implements BasicProductSellingPriceService {

    @Resource
    private BasicProductService basicProductService;

    @Override
    public List<BasicProductSellingPriceVO> listDetail() {
        // 获取所有的销售价格和产品
        List<BasicProductSellingPrice> sellingPriceList = this.list();
        List<BasicProduct> productList = basicProductService.list();

        // 将产品列表转换为一个map，其中key是产品ID，值是产品对象
        Map<Integer, BasicProduct> productMap = productList.stream()
                .collect(Collectors.toMap(BasicProduct::getId, Function.identity()));

        // 将销售价格列表转换为VO列表

        return sellingPriceList.stream().map(sellingPrice -> {
            BasicProduct product = productMap.get(sellingPrice.getProductId());
            if (product == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"找不到产品ID: " + sellingPrice.getProductId());
            }

            BasicProductSellingPriceVO vo = new BasicProductSellingPriceVO();
            // 先复制BasicProduct的属性，然后覆盖它们
            BeanUtils.copyProperties(product, vo);
            // 再复制BasicProductSellingPrice的属性，这样如果两个对象有相同的属性，BasicProductSellingPrice的值会覆盖BasicProduct的值
            BeanUtils.copyProperties(sellingPrice, vo);
            return vo;
        }).collect(Collectors.toList());
    }

}





