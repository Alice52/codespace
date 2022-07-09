package top.hubby.codespace.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zack <br>
 * @create 2022-07-09 17:33 <br>
 * @project java-web <br>
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code = 0;
    private String msg = "success";
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = 1;
    }

    @NotNull
    public static <T> R<T> success(@Nullable T data) {

        return R.<T>builder().msg("success").data(data).build();
    }

    @NotNull
    public static <T> R<T> success() {

        return R.<T>builder().msg("success").build();
    }
}
