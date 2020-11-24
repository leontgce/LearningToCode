package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import dao.MusicaDAO;

import java.util.List;
import java.util.ArrayList;

import entity.Musica;

@ManagedBean
public class MusicaBean {
	private Musica musica = new Musica();
	private List<Musica> lista;
	
	public String salvar() {
		MusicaDAO.salvar(musica);
		musica = new Musica();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrada" , "Música salva com sucesso."));
		return null;
	}
	
	public String editar() {
		MusicaDAO.editar(musica);
		musica = new Musica();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Dados da música editado(s) com sucesso."));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "listar.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		MusicaDAO.excluir(musica);
		return "listar.xhtml?faces-redirect=true";
	}
	
	public String prepararEdicao() {
		return "editar.xhtml";
	}
	
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	public List<Musica> getLista() {
		if (lista == null) {
			lista = MusicaDAO.listar();
		}
		return lista;
	}
	public void setLista(List<Musica> lista) {
		this.lista = lista;
	}
}
