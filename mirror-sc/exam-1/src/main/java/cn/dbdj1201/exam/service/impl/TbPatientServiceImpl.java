package cn.dbdj1201.exam.service.impl;

import cn.dbdj1201.exam.entity.TbPatient;
import cn.dbdj1201.exam.mapper.TbPatientMapper;
import cn.dbdj1201.exam.service.ITbPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-24
 */
@Service
public class TbPatientServiceImpl extends ServiceImpl<TbPatientMapper, TbPatient> implements ITbPatientService {

}
