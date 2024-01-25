package space.akko.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import space.akko.springbootinit.model.domain.BasicProductSellingPrice;
import space.akko.springbootinit.model.vo.BasicProductSellingPriceVO;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【basic_product_selling_price(产品销售价格表)】的数据库操作Service
 * @createDate 2024-01-08 10:21:52
 */
public interface BasicProductSellingPriceService extends IService<BasicProductSellingPrice> {

    List<BasicProductSellingPriceVO> listDetail();
}
