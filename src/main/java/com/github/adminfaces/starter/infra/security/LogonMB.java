package com.github.adminfaces.starter.infra.security;

import br.com.revisa.teste.entidades.Usuario;
import br.com.revisa.teste.services.ServiceUsuario;
import br.com.revisa.teste.services.impl.UsuarioServiceImpl;
import br.com.revisa.teste.util.FacesMensagensUtil;
import com.github.adminfaces.template.session.AdminSession;
import org.omnifaces.util.Faces;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login
 * page or not. By default AdminSession isLoggedIn always resolves to true so it
 * will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user
 * must be redirect to initial page or logon you can skip this class.
 */
//Classe apenas alterada para o uso
@Named
@SessionScoped //esse scopo é de sessão estará disponível por toda a sessão do usuário
@Specializes
public class LogonMB extends AdminSession implements Serializable {

    private Usuario usuarioLogado;

    private ServiceUsuario usuarioService;

    public LogonMB() {

    }

    //método que executa logo após a criação da sessão
    @PostConstruct
    private void init() {
        usuarioService = new UsuarioServiceImpl();
        usuarioLogado = new Usuario();
    }

    public void onEntrar() {
        try {

            usuarioLogado = usuarioService.onLogar(usuarioLogado);
            if (usuarioLogado != null) {
                Faces.redirect("sistema/inicio.revisa");
            } else {
                usuarioLogado = new Usuario();
                FacesMensagensUtil.adcionarMensagemErro("Usuário e/ou Senha inválida(s)");
            }

        } catch (Exception e) {
            e.printStackTrace(); //apenas para mostrar no console
            FacesMensagensUtil.adcionarMensagemErro("Ocorreu um erro ao realizar o login, tente novamente mais tarde.");
        }
    }

    @Override
    public boolean isLoggedIn() {
        return usuarioLogado.getId() != null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado; //acessa em outros MB para pegar o nome, verificar permissões, etc
    }

}
