package org.example.controller;

import org.example.container.Container;
import org.example.service.ExportService;

public class ExportController extends Controller {
    private ExportService exportService;

    public ExportController() {
        exportService = Container.exportService;
    }

    public void doAction(String cmd, String actionMethodName) {
        switch(actionMethodName) {
            case "html" :
                doHtml();
                break;
            default :
                System.out.println("존재하지 않는 서비스입니다.");
                break;
        }
    }

    private void doHtml() {
        System.out.println("호텔 숙박 후기 html을 생성하였습니다.");
        exportService.makeHtml();
    }
}
