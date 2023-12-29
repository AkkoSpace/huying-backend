package space.akko.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import space.akko.springbootinit.mapper.CompaniesMapper;
import space.akko.springbootinit.model.entity.Companies;
import space.akko.springbootinit.service.CompaniesService;

/**
 * @author Administrator
 * @description 针对表【companies(公司)】的数据库操作Service实现
 * @createDate 2023-12-29 16:36:59
 */
@Service
public class CompaniesServiceImpl extends ServiceImpl<CompaniesMapper, Companies>
        implements CompaniesService {

}




