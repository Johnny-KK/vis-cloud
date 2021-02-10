package com.johnny.vis.cloud.admin.vo;

import cn.hutool.core.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny
 * @date 2021-02-09
 */
@Getter
@Setter
public class ServerWithServeVo implements Serializable {

    private static final long serialVersionUID = -2413835919769989406L;

    public ServerWithServeVo() {
    }

    public ServerWithServeVo(Map<String, Object> map) {
        BeanUtil.copyProperties(map, this);
        if (this.serveList == null) {
            this.serveList = new ArrayList<>();
        }
        if (map.get("serveId") != null) {
            ServeVo vo = new ServeVo();
            BeanUtil.copyProperties(map, vo);
            this.serveList.add(vo);
        }
    }

    /**
     * 服务器ID
     */
    private Long id;

    /**
     * 服务器名称
     */
    private String serverName;

    /**
     * 服务器IP
     */
    private String serverIp;

    /**
     * 服务器域名
     */
    private String serverDomain;

    /**
     * 下属服务列表
     */
    private List<ServeVo> serveList;

    @Setter
    @Getter
    public static class ServeVo implements Serializable {

        private static final long serialVersionUID = 3759306404641026859L;

        /**
         * 服务ID
         */
        private Long serveId;

        /**
         * 服务名称
         */
        private String serveName;

        /**
         * 服务端口
         */
        private String servePort;
    }
}
