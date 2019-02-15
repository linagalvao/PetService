/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.utilitarios.typehandler;

import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 *
 * @author Lina
 */
public class EspecieTypeHandler implements TypeHandler<EspecieEnum>{

    @Override
    public void setParameter(PreparedStatement ps, int i, EspecieEnum t, JdbcType jt) throws SQLException {
        ps.setString(i, t.getValor());
    }

    @Override
    public EspecieEnum getResult(ResultSet rs, String string) throws SQLException {
        String result = rs.getString(string);
        return EspecieEnum.getTipoEspecieEnum(result);
    }

    @Override
    public EspecieEnum getResult(ResultSet rs, int i) throws SQLException {
        String result = rs.getString(i);
        return EspecieEnum.getTipoEspecieEnum(result);
    }

    @Override
    public EspecieEnum getResult(CallableStatement cs, int i) throws SQLException {
        String valorColuna = cs.getString(i);
        return EspecieEnum.getTipoEspecieEnum(valorColuna);
    }

   
}

