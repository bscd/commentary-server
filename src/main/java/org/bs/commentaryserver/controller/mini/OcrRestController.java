package org.bs.commentaryserver.controller.mini;


import com.baidu.aip.ocr.AipOcr;
import org.bs.common.baiduAI.AIFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 */
@RestController
@RequestMapping(value = "/orc")
public class OcrRestController
{
    AipOcr aipOcr = AIFactory.getAipOcr();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


}
