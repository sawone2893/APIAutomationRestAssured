package serviceObjects;

import services.AdminsService;
import services.BrandsService;
import services.CategoriesService;
import services.CommonService;
import services.UsersService;

public class ServiceObjectsManager {
	
	public AdminsService getAdminsService() {
		return AdminsService.getInstance();
	}
	
	public BrandsService getBrandsService() {
		return BrandsService.getInstance();
	}
	
	public CommonService getCommonService() {
		return CommonService.getInstance();
	}
	
	public UsersService getUsersService() {
		return UsersService.getInstance();
	}
	
	public CategoriesService getCategoriesService() {
		return CategoriesService.getInstance();
	}

}
