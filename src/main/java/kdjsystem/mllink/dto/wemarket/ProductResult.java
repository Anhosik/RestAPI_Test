package kdjsystem.mllink.dto.wemarket;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResult {
    private String productNo;
    private String returnMsg;
}


