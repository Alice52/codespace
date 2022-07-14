package top.hubby.codespace.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.hubby.codespace.model.entity.Phase;
import top.hubby.codespace.model.vo.R;
import top.hubby.codespace.service.PhaseService;
import java.util.ArrayList;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zack <br>
 * @create 2022-07-09 17:32 <br>
 * @project java-web <br>
 */
@Slf4j
@Api(tags = {"Phase Manage Api"})
@RestController
@RequestMapping("/custom")
public class PhaseController {
    @Resource private PhaseService phaseService;

    @GetMapping("/phases")
    public R<List<Phase>> list(
            @RequestParam(value = "type", required = false) @ApiParam(value = "活动标识") String type) {

        return R.success(phaseService.listPhases(type));
    }
}
