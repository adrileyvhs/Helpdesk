package com.dev.helpdesk.domain.dtos;
import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
@Data
public class ChamadoDto implements Serializable {
    private static final long serialVersionUID = 1L;
        private Integer id;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataAbertura = LocalDate.now();
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataFechamento;
        @NotNull(message = "Campo prioridade Obrigatorio")
        private Integer prioridade;
        private Status  status;
        private String  titulo;
        private String  observacoes;
        @NotNull(message = "Campo tecnico Obrigatorio")
        private Integer tecnico;
        @NotNull(message = "Campo cliente Obrigatorio")
        private Integer cliente;
        private String nomeliente;
        private String nomeTecnico;

    public ChamadoDto() {
    }

    public ChamadoDto(Chamado Obj) {
        this.id = Obj.getId();
        this.dataAbertura = Obj.getDataAbertura();
        this.dataFechamento = Obj.getDataFechamento();
        this.prioridade = Obj.getPrioridade().getCodigo();
        this.status = Status.toEnum(Obj.getStatus().getCodigo());
        this.titulo =Obj.getTitulo();
        this.observacoes =Obj. getObservacoes();
        this.tecnico = Obj.getTecnico().getId();
        this.cliente = Obj.getCliente().getId();
        this.nomeliente = Obj.getCliente().getNome();
        this.nomeTecnico = Obj.getTecnico().getNome();
    }
    //

}
