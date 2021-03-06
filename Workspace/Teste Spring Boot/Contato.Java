@Entity
public class Contato implements Serializable {
 
  private static final long serialVersionUID = 1L;
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
   
  private String nome;
   
  private String email;
 
  // getters e setters omitidos
}