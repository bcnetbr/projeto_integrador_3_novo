/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.Collection;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@FacesConverter(value = "converterEntity")
@Component("converterEntity")
@Qualifier("converterEntity")
public class ConverterEntity implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Object ret = null;
        UIComponent fonte = arg1;
        Collection values = null;
        if (fonte != null) {
            Collection<UIComponent> childs = fonte.getChildren();
            UISelectItems itens = null;
            if (childs != null) {
                for (UIComponent ui : childs) {
                    if (ui instanceof UISelectItems) {
                        itens = (UISelectItems) ui;
                        break;
                    } else if (ui instanceof UISelectItem) {
                        UISelectItem item = (UISelectItem) ui;
                        try {
                            Object val = item.getItemValue();
                            try {
                                String chave = "" + PropertyUtils.getProperty(val, "id");
                                if (arg2.equals("" + chave)) {
                                    ret = val;
                                    break;
                                }
                            } catch (Exception ex) {
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }

            if (itens != null) {
                values = (Collection) itens.getValue();
                if (values != null) {
                    try {
                        for (Object val : values) {
                            try {
                                String chave = "" + PropertyUtils.getProperty(val, "id");
                                if (arg2.equals("" + chave)) {
                                    ret = val;
                                    break;
                                }
                            } catch (Exception ex) {
                            }
                        }
                    } catch (ClassCastException e) {
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public final String getAsString(final FacesContext contexto, final UIComponent componente, final Object valor) {
        if (valor != null) {
            try {
                final String chave = "" + PropertyUtils.getProperty(valor, "id");
                return chave;
            } catch (Exception ex) {
            }
        }
        return null;
    }
}
