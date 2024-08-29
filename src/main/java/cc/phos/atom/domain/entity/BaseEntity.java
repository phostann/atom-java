package cc.phos.atom.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-28 16:23:29
 */
@Data
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8258158159532584566L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 创建时间
     */
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * 逻辑删除; 0 为删除; 1 删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;
}
