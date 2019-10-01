package com.garagonic.goodsin.controllers;

//import com.garagonic.goodsin.repository.GoodsRepository;

//@Controller
//@RequestMapping("/goods")
public class GoodsController {
//
//    @RequestMapping(value = "/goods", method = RequestMethod.GET)
//    public ModelAndView showGoods(){
//        return  new ModelAndView("goodsInPage","goods", new Goods());
//    }
//
//    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
//    public String add(@Valid @ModelAttribute("goods")Goods goods, BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        model.addAttribute("id", goods.getId());
//        model.addAttribute("title", goods.getTitle());
//        model.addAttribute("po", goods.getPO());
//        model.addAttribute("wo", goods.getWO());
//        model.addAttribute("so", goods.getSO());
//        model.addAttribute("customer", goods.getCustomer());
//        model.addAttribute("rack", goods.getRack());
//        model.addAttribute("shelf", goods.getShelf());
//        model.addAttribute("shelf_position", goods.getShelfPosition());
//        model.addAttribute("barcode", goods.getBarcode());
//        model.addAttribute("in_date", goods.getInDate());
//        model.addAttribute("out_date", goods.getOutDate());
//        return "showAllGoods";
//    }



//    @GetMapping("/goods")
//    public List<Goods> index(){
//        return goodsRepository.findAll();
//    }
//
//    @GetMapping("/goods/{id}")
//    public Goods show(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        return goodsRepository.findOne(id);
//    }
//
//    @PostMapping("/goods/search")
//    public List<Goods> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return goodsRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }
//
//    @PostMapping("/blog")
//    public Goods create(@RequestBody Map<String, String> body){
//        String title = body.get("title");
//        String content = body.get("content");
//        return goodsRepository.save(new Goods());
//    }
//
//    @PutMapping("/goods/{id}")
//    public Goods update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int blogId = Integer.parseInt(id);
//        // getting blog
//        Goods goods = goodsRepository.findOne();
//        goods.setTitle(body.get("title"));
//        goods.setContent(body.get("content"));
//        return goodsRepository.save(goods);
//    }
//
//    @DeleteMapping("goods/{id}")
//    public boolean delete(@PathVariable String id){
//        int blogId = Integer.parseInt(id);
//        goodsRepository.delete(blogId);
//        return true;
//    }
}
