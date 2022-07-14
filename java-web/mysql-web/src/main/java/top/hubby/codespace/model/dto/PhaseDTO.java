package top.hubby.codespace.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.hubby.codespace.constants.enums.PhaseStatusEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zack <br>
 * @create 2021-04-09 10:21 <br>
 * @project integration <br>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhaseDTO implements Serializable {

  @ApiModelProperty(hidden = true)
  private Long id;

  @ApiModelProperty("阶段Code")
  private String phaseCode;

  @ApiModelProperty("阶段名称")
  private String phaseName;

  @ApiModelProperty("阶段开始时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startTime;

  @ApiModelProperty("阶段结束时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endTime;

  @ApiModelProperty(hidden = true)
  private String type;

  @ApiModelProperty(hidden = true)
  private PhaseStatusEnum status;

  public PhaseDTO(Long id, String type) {
    this.id = id;
    this.type = type;
  }

  public PhaseDTO(Long id) {
    this.id = id;
  }
}
