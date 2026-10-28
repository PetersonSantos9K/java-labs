package util;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MapService<TypeResponse, TypeModel>{
    protected abstract  TypeResponse mapRow(TypeModel typeModel);

    protected List<TypeResponse> mapList(List<TypeModel> models) {
        return models.stream()
                .map(this::mapRow).collect(Collectors.toList());
    }


}
