# Repro Dagger incremental compilation bug with Gradle

Compile with `./gradlew :lib:compileJava -i` and see the generated Dagger component:

```
public final class DaggerDaggerComponent implements DaggerComponent {
  private DaggerDaggerComponent() {}

  public static Builder builder() {
    return new Builder();
  }

  public static DaggerComponent create() {
    return new Builder().build();
  }

  @Override
  public Set<Base> getObjects() {
    return Collections.<Base>singleton(new SubclassA());
  }

  public static final class Builder {
    private Builder() {}

    public DaggerComponent build() {
      return new DaggerDaggerComponent();
    }
  }
}
```

`getObjects()` contains an instance of `SubclassA`, as expected. Then edit `DaggerModule` to uncomment `provideSubclassB()`. Re-running the compilation will recompile the module, but won't regenerate the dagger component to add the second element to the set returned by `getObjects()`.