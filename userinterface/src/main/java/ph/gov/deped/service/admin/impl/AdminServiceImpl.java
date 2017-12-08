package ph.gov.deped.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.RequestContext;
import ph.gov.deped.service.admin.api.AdminService;
import ph.gov.deped.service.admin.api.DashboardRequest;
import ph.gov.deped.service.admin.api.DashboardResponse;

public @Service class AdminServiceImpl implements AdminService {
    
    private @Autowired DashboardCommand dashboardCommand;

    public @Transactional(value = AppMetadata.TXM, readOnly = true) DashboardResponse dashboard() {
        DashboardRequest request = new DashboardRequest(new RequestContext());
        DashboardContext context = new DashboardContext(request);
        dashboardCommand.execute(context);
        DashboardResponse response = context.getResponse();
        return response;
    }

}
