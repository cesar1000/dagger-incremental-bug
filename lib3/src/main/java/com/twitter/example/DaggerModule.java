package com.twitter.example;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import dagger.multibindings.Multibinds;
import java.util.Set;

@Module
abstract class DaggerModule {
  @Multibinds
  abstract Set<Base> getObjects();

  @Binds
  @IntoSet
  abstract Base provideSubclassA(SubclassA subclass);

  // Uncommenting this binding won't cause the component to be regenerated.
  // @Binds
  // @IntoSet
  // abstract Base provideSubclassB(SubclassB subclass);
}
