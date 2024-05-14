package org.example.lab10.task1;

import org.example.lab10.CustomContainer;
import org.example.lab10.task1.exceptions.CannotProvideInstance;
import org.example.lab10.task1.exceptions.InvalidType;
import org.example.lab10.task1.exceptions.NullParameter;
import org.example.lab10.task1.exceptions.RedeclaredInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Task1 implements CustomContainer {
    private Map<String, Object> instances = new HashMap<>();
    private Map<Class<?>, Function<?, CustomContainer>> factoryMethods = new HashMap<>();

//    Task 1
    @Override
    public <T> boolean addInstance(T instance) {
        return addInstance(instance, instance.getClass().getName());
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new NullParameter("Null is not allowed as a parameter");
        }

        if (instances.get(instance.getClass().getName()) != null) {
            throw new RedeclaredInstance("Instances cannot be redeclared");
        }

        instances.put(customName, instance);
        return true;
    }

//    Task 2
    @Override
    public <T> T getInstance(Class<T> type) {
        return getInstance(type, type.getName());
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null) {
            throw new NullParameter("Null is not allowed as a parameter");
        }

        T instance = (T) instances.get(customName);
        if (instance.getClass().getTypeName().equals(type.getName())) {
            return instance;
        }

        throw new InvalidType("Invalid type for object");
    }

//    Task 3
    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<T, CustomContainer> factoryMethod) {
        if (type == null) {
            throw new NullParameter("Null is not allowed as a parameter");
        }

        factoryMethods.put(type, factoryMethod);
        return true;
    }

//    Task 4
    public <T> T getInstance3(Class<T> type, String customName) {
        if (type == null) {
            throw new NullParameter("Null is not allowed as a parameter");
        }

        T instance = (T) instances.get(customName);
        if (instance != null && instance.getClass().getTypeName().equals(type.getName())) {
            return instance;
        }

        Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factoryMethods.get(type);
        if (factoryMethod != null) {
            instance = factoryMethod.apply(this);
            instances.put(customName, instance);
            return instance;
        }

        throw new CannotProvideInstance("Cannot provide instance");
    }

//    Task 5
    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null) {
            throw new NullParameter("Null is not allowed as a parameter");
        }

        Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factoryMethods.get(type);
        if (factoryMethod == null) {
            throw new CannotProvideInstance("Cannot provide instance");
        }

        Task1 parameterContainer = new Task1();
        parameterContainer.instances = new HashMap<>(parameters);

        return factoryMethod.apply(parameterContainer);
    }

    @Override
    public void close() throws Exception {

    }
}
