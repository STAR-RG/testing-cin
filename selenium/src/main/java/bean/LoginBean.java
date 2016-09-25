package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String senha;
	private Usuario usuario;
	
	public String login() {
		String retorno = "";
		
		if (this.login.equals("admin") && this.senha.equals("123")) {
			usuario = new Usuario();
			usuario.setNome(this.login);
			retorno = "exibirInicio"; 
		} else {
			 FacesContext.getCurrentInstance().addMessage(
				"j_idt6:submit", new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Erro: Usuário ou senha incorreta.", ""));
		}	
		return retorno;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
