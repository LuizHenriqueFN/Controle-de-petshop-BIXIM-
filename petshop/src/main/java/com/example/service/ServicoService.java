package com.example.service;

import com.example.model.Servico;
import com.example.dao.ServicoDAO;

public class ServicoService {
    private ServicoDAO servicodao = new ServicoDAO();

    public ServicoService() {}

    private boolean isValid(Servico servico){
        if( 
            servico.getCodigo() != 0    ||
            servico.getNome() != ""     ||
            servico.getValor() != 0f
        ) {
            return true;
        }
        
        return false;
    }

    public boolean inserir(Servico servico) {
        if(isValid(servico) && servicodao.inserir(servico)) return true;
        return false;
    }

    public boolean alterar(int codigo, Servico servico) {
        if(isValid(servico) && servicodao.alterar(codigo, servico)) return true;
        return false;
    }

    public boolean remover(int codigo) {
        if(servicodao.remover(codigo)) return true;
        return false;
    }

    public void limpaDados() {
        servicodao.limpaDados();
    }

    public Servico getServico(int codigo){
        Servico servico = servicodao.getServico(codigo);
        if(servico != null) return servico;

        System.out.println("ERRO! Serviço não encontrado");
        return null;
    }

    @Override
    public String toString() {
        Object servicos[] = servicodao.getAll().toArray();
        String string = "";

        for (int i = 0; i < servicos.length; i++) {
            if(servicos[i] != null){
                string += servicos[i].toString();
                string += '\n';
            }
        }

        return string;
    }

}

