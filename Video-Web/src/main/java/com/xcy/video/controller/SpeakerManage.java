package com.xcy.video.controller;


import com.xcy.video.pojo.Speaker;
import com.xcy.video.service.SpeakerService;
import com.xcy.video.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpeakerManage {

    @Autowired
    SpeakerService speakerService;
    @RequestMapping("/teachermanage")
    public String showSpeaker(Model model, Speaker speaker){


        speaker.setBegin((speaker.getPage() - 1) * speaker.getRows() );
        List<Speaker> speakers1 = speakerService.selectAll(speaker);
        Page<Speaker> page = new Page<Speaker>();
        page.setPage(speaker.getPage());
        page.setSize(speaker.getRows());
        page.setTotal(speakerService.getCount(speaker));
        page.setRows(speakers1);
        model.addAttribute("page",page);

   /* List<Speaker> speakers = speakerService.selectAllSpeaker();
    model.addAttribute("list",speakers);*/
        return "behind/teachermanage";
    }

    @RequestMapping("/deleteSpeaker")
    public String delete(int id){
        speakerService.deleteSpeaker(id);
        return "redirect:/teachermanage";
    }

    @RequestMapping("/addSpeaker")
    public String addSpeaker(){

        return "behind/addteacher";
    }

    @RequestMapping("/updatSpeaker")
    public String updateSpeaker(int id,Model model){
        Speaker speaker = speakerService.getSpeakerById(id);
        model.addAttribute("speaker",speaker);
        return "behind/addteacher";
    }

    @RequestMapping("/saveSpeaker")
    public String addSpeaker(Speaker speaker){
        speakerService.addSpeaker(speaker);

        return "redirect:/teachermanage";
    }

}
