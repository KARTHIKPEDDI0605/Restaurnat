//package com.RestaurantRegister.Restaurant.Models.Converter;
//
//import jakarta.persistence.Entity;
//import org.springframework.core.convert.ConverterNotFoundException;
//import org.springframework.core.convert.TypeDescriptor;
//import org.springframework.core.convert.converter.GenericConverter;
//import org.springframework.util.Assert;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.Optional;
//import java.util.Set;
//
//public abstract class EntityDtoConverter<E, D> implements GenericConverter {
//    private final Class<E> entityClass;
//    private final Class<D> dtoClass;
//
//    protected EntityDtoConverter() {
//        Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
//
//        this.entityClass = (Class) types[0];
//        Optional<Entity> entityParam = Optional.ofNullable(entityClass.getAnnotation(Entity.class));
//        Assert.isTrue(entityParam.isPresent(), "First type should be an entity");
//
//        this.dtoClass = (Class) types[1];
//        Optional<Entity> nonEntityParam = Optional.ofNullable(dtoClass.getAnnotation(Entity.class));
//        Assert.isTrue(nonEntityParam.isEmpty(), "Second type should not be an entity");
//    }
//
//    @Override
//    public Set<ConvertiblePair> getConvertibleTypes() {
//        return Set.of(new ConvertiblePair(entityClass, dtoClass));
//    }
//
//    @Override
//    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
//        if (entityClass.equals(sourceType.getType())) {
//            return this.toDto((E) source);
//        } else {
//            return this.toEntity((D) source);
//        }
//    }
//
//    protected abstract D toDto(E source);
//
//    protected E toEntity(D target) {
//        throw new ConverterNotFoundException(TypeDescriptor.forObject(target), TypeDescriptor.valueOf(entityClass));
//    }
//}
