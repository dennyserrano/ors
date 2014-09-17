package ph.gov.deped.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ph.gov.deped.data.dto.DashboardDto;
import ph.gov.deped.service.admin.api.AdminService;
import ph.gov.deped.service.admin.api.DashboardResponse;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    
    public static final String DASHBOARD_VIEW = "admin/dashboard";
    
    public static final String DASHBOARD_MODEL = "dashboard";
    
    private @Autowired AdminService adminService;
    
    @ModelAttribute(DASHBOARD_MODEL)
    public DashboardDto dashboard() {
        return new DashboardDto();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view(@ModelAttribute(DASHBOARD_MODEL) DashboardDto dashboard) {
        DashboardResponse response = adminService.dashboard();
        dashboard.setDatasets(response.getDatasets());
        dashboard.setDataSourceStatus(response.getDataSourceStatus());
        dashboard.setMemory(response.getMemory());
        dashboard.setUsers(response.getUsers());
        return DASHBOARD_VIEW;
    }
}
