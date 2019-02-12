package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Notice;
import net.itinajero.app.service.INoticeService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@Autowired
	private INoticeService noticeService;

	@GetMapping(value = "/create")
	public String createNotice() {
		return "notice/formNotice";
	}

	@PostMapping(value = "/save")
	public String save(Notice notice) {
		noticeService.save(notice);
		return "notice/formNotice";
	}
}
