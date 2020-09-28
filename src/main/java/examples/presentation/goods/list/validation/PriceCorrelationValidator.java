package examples.presentation.goods.list.validation;

import examples.presentation.goods.list.form.GoodsSearchForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PriceCorrelationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return GoodsSearchForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        int priceMin = 0;
        int priceMax = 0;

        GoodsSearchForm form = (GoodsSearchForm) target;

        if(!form.getPriceMin().isEmpty()){
            priceMin = Integer.parseInt(form.getPriceMin());
        }

        if(!form.getPriceMax().isEmpty()){
            priceMax = Integer.parseInt(form.getPriceMax());
        }

        if (priceMin > priceMax) {
            errors.rejectValue(
                    "priceMin",
                    "PasswordEqualsValidator.passwordResetForm.password",
                    "値段(FROM)～値段(TO)の範囲内で入力してください。"
            );
        }
    }
}
