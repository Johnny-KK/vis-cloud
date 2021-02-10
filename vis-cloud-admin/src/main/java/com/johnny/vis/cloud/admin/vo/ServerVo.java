package com.johnny.vis.cloud.admin.vo;

import com.johnny.vis.cloud.admin.entity.ServeEntity;
import com.johnny.vis.cloud.admin.entity.ServerEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Johnny
 * @date 2021-02-09
 */
@Getter
@Setter
public class ServerVo extends ServerEntity implements Serializable {

    private static final long serialVersionUID = -2413835919769989406L;

    /**
     * 下属服务列表
     */
    private List<ServeEntity> serveList;
}
