package top.hubby.codespace.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.validation.annotation.Validated;
import top.hubby.codespace.model.entity.Phase;

import java.util.List;
import java.util.Optional;

/**
 * @author zack <br>
 * @create 2022-04-08<br>
 * @project project-cloud-custom <br>
 */
@Validated
public interface PhaseService extends IService<Phase> {

  /**
   * 获取所有阶段信息
   *
   * @param type 标识具体活动
   * @return
   */
  List<Phase> listPhases(String type);

  /**
   * Get Phase According By Condition.
   *
   * @param entity
   * @return
   */
  default Phase getByCondition(Phase entity) {
    LambdaQueryWrapper<Phase> queryWrapper = buildQueryWrapper();

    Optional.ofNullable(entity.getId())
        .ifPresent(t -> queryWrapper.eq(Phase::getId, entity.getId()));
    Optional.ofNullable(entity.getType())
        .ifPresent(t -> queryWrapper.eq(Phase::getType, entity.getType()));
    Optional.ofNullable(entity.getPhaseCode())
        .ifPresent(t -> queryWrapper.eq(Phase::getPhaseCode, entity.getPhaseCode()));
    Optional.ofNullable(entity.getPhaseName())
        .ifPresent(t -> queryWrapper.eq(Phase::getPhaseName, entity.getPhaseName()));

    queryWrapper.last("LIMIT 1");

    return this.getOne(queryWrapper);
  }

  /**
   * Build Query Wrapper.
   *
   * @return
   */
  default LambdaQueryWrapper<Phase> buildQueryWrapper() {
    return buildQueryWrapper(null);
  }

  /**
   * Build Query One Wrapper.
   *
   * @param type
   * @return
   */
  default LambdaQueryWrapper<Phase> buildQueryWrapper(String type) {
    LambdaQueryWrapper<Phase> queryWrapper = Wrappers.<Phase>query().lambda();
    Optional.ofNullable(type).ifPresent(t -> queryWrapper.eq(Phase::getType, type));

    return queryWrapper;
  }
}
