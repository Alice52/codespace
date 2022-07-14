package top.hubby.codespace.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hubby.codespace.mapper.PhaseMapper;
import top.hubby.codespace.model.entity.Phase;
import top.hubby.codespace.service.PhaseService;

import java.util.List;

/**
 * @author zack <br>
 * @create 2022-04-08<br>
 * @project project-cloud-custom <br>
 */
@Service
public class PhaseServiceImpl extends ServiceImpl<PhaseMapper, Phase> implements PhaseService {

  @Override
  public List<Phase> listPhases(String type) {

    return getPhases(type);
  }

  private List<Phase> getPhases(String type) {
    LambdaQueryWrapper<Phase> queryWrapper = buildQueryWrapper(type);

    return this.list(queryWrapper);
  }
}
