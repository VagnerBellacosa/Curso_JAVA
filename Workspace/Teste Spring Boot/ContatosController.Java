@Controller
@RequestMapping("/contatos")
public class ContatosController {
   
  @Autowired
  private Contatos contatos;
   
  @GetMapping
  public ModelAndView listar() {
    List&lt;Contato&gt; lista = contatos.findAll();
     
    ModelAndView modelAndView = new ModelAndView("contatos");
    modelAndView.addObject("contatos", lista);
     
    return modelAndView;
  }
}