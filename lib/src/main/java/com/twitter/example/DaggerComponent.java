package com.twitter.example;

import dagger.Binds;
import dagger.Component;
import java.util.Set;

@Component(modules = AllModules.class)
interface 
DaggerComponent {
  Set<Base> getObjects();
}
