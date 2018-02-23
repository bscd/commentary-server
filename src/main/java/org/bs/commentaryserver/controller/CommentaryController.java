package org.bs.commentaryserver.controller;


import org.bs.commentaryserver.Responser.SuccessRsp;
import org.bs.commentaryserver.db.model.Spot;
import org.bs.commentaryserver.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bs
 */
@RestController
@RequestMapping(value = "/Commentary")
public class CommentaryController
{
    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private SuccessRsp successRsp;

    @ResponseBody
    @RequestMapping(value = "/querySpotsByCity",
                    produces = {"application/json;charset=UTF-8"})
    public String querySpots(@RequestParam("province") String province, @RequestParam("city") String city)
    {
        List<Spot> lstSpots = commentaryService.querySpotsByCity(province, city);

        return successRsp.buildMsg(lstSpots);
    }
}
