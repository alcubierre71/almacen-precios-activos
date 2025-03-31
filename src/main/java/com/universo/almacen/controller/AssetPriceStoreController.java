package com.universo.almacen.controller;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface AssetPriceStoreController {

	public String viewHomePage(Model model);
	
	public String downloadPricesHome(Model model);
	
	public ModelAndView viewDownloadPrices(Long id) throws IOException;
	
	public ModelAndView viewDownloadPricesFt(Long id) throws IOException;
	
	public ModelAndView runDownloadPricesFt(Long id) throws IOException;
	
}
