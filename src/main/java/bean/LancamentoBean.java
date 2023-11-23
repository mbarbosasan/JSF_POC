package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import DAO.LancamentoDAO;
import entites.Lancamento;

@ManagedBean
public class LancamentoBean {
	private Lancamento lancamento = new Lancamento();
	private List<Lancamento> lista = new ArrayList<>();
	
	public String salvar() {
		try {
			LancamentoDAO.salvar(lancamento);
			lancamento = new Lancamento();
			FacesContext.getCurrentInstance().addMessage("msgSucessoSalvar", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", 
							"As informações foram salvas com sucesso."));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("msgSucessoSalvar", 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ocorreu um erro ao salvar!", 
							"Por favor, tente novamente!."));
		}
		return null;
	}
	
	public void deletar(Lancamento lancamento) {
		   this.lista.remove(lancamento);
		   LancamentoDAO.deletarPorId(lancamento);
		} 
	
	public List<Lancamento> getList() {
		   lista = LancamentoDAO.listarTodos();
		   return lista;
		}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Lancamento> getLista() {
		return lista;
	}

	public void setLista(List<Lancamento> lista) {
		this.lista = lista;
	}

}
