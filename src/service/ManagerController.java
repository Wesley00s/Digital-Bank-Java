package service;

public class ManagerController {
    private final ManagerService managerService;
    private final AccountService accountService;

    public ManagerController(ManagerService managerService, AccountService accountService) {
        this.managerService = managerService;
        this.accountService = accountService;
    }
    
}
