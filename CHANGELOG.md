# Changelog

## [1.0.0](https://github.com/Heroshrine/SmokerEffects/releases/tag/v1.0.0) (2026-09-28)

This is the first release of Smoker Effects, for Minecraft 26.1.2 on NeoForge. It adds seasoning pouches, which you burn in a smoker to cook food that gives weak but long-lasting effects when eaten.

### Seasoning Pouches

* **seasoning:** add the empty seasoning pouch, crafted from 4 wheat around a piece of coal or charcoal ([#1](https://github.com/Heroshrine/SmokerEffects/issues/1)) ([9a4a320](https://github.com/Heroshrine/SmokerEffects/commit/9a4a320597dda9a11e6b2c01c14ee4d8c51b0ac8))
* **seasoning:** fill a pouch with 1–3 seasonings in a crafting table, and top up a partly filled pouch the same way ([#1](https://github.com/Heroshrine/SmokerEffects/issues/1)) ([9a4a320](https://github.com/Heroshrine/SmokerEffects/commit/9a4a320597dda9a11e6b2c01c14ee4d8c51b0ac8))
* **seasoning:** the pouch tooltip lists the seasonings inside ([#1](https://github.com/Heroshrine/SmokerEffects/issues/1)) ([9a4a320](https://github.com/Heroshrine/SmokerEffects/commit/9a4a320597dda9a11e6b2c01c14ee4d8c51b0ac8))
* **seasoning:** seasoning pouches can be burned as fuel in smokers ([#1](https://github.com/Heroshrine/SmokerEffects/issues/1)) ([9a4a320](https://github.com/Heroshrine/SmokerEffects/commit/9a4a320597dda9a11e6b2c01c14ee4d8c51b0ac8))
* **seasoning:** seasoning items show "Seasoning" in their tooltip ([#4](https://github.com/Heroshrine/SmokerEffects/issues/4)) ([1592011](https://github.com/Heroshrine/SmokerEffects/commit/1592011b1b5d3b2117b50251e00ce66f0c40cb50))

### Seasoned Food

* **seasoning:** food cooked in a smoker that is burning a filled seasoning pouch becomes seasoned ([#3](https://github.com/Heroshrine/SmokerEffects/issues/3)) ([7ed2e23](https://github.com/Heroshrine/SmokerEffects/commit/7ed2e234b306145d2ab16af3f7651b4163d13478))
* **seasoning:** a smoker burning a seasoning pouch shows its seasonings under the output slot ([#3](https://github.com/Heroshrine/SmokerEffects/issues/3)) ([7ed2e23](https://github.com/Heroshrine/SmokerEffects/commit/7ed2e234b306145d2ab16af3f7651b4163d13478))
* **seasoning:** eating seasoned food gives the effects it was seasoned with, and its tooltip lists them ([#3](https://github.com/Heroshrine/SmokerEffects/issues/3)) ([7ed2e23](https://github.com/Heroshrine/SmokerEffects/commit/7ed2e234b306145d2ab16af3f7651b4163d13478))
* **seasoning:** seasoning effects last for minutes at a time, and longer on more filling food ([#4](https://github.com/Heroshrine/SmokerEffects/issues/4)) ([1592011](https://github.com/Heroshrine/SmokerEffects/commit/1592011b1b5d3b2117b50251e00ce66f0c40cb50))
* **seasoning:** adding the same seasoning to a pouch more than once adds up its effect duration ([#3](https://github.com/Heroshrine/SmokerEffects/issues/3)) ([7ed2e23](https://github.com/Heroshrine/SmokerEffects/commit/7ed2e234b306145d2ab16af3f7651b4163d13478))
* **seasoning:** when a pouch has the same effect at different levels, the stronger one becomes extra duration at the lower level ([#4](https://github.com/Heroshrine/SmokerEffects/issues/4)) ([1592011](https://github.com/Heroshrine/SmokerEffects/commit/1592011b1b5d3b2117b50251e00ce66f0c40cb50))

### Seasonings

* **seasoning:** add seasonings: beetroot, carrot, clay ball, eggs, dandelion, iron nugget, feather, bamboo, prismarine crystals, pufferfish, armadillo scute, turtle scute, phantom membrane, resin clump, ghast tear, chorus fruit, popped chorus fruit, ender pearl, rotten flesh, spider eye, poisonous potato, dragon's breath, and flint ([#4](https://github.com/Heroshrine/SmokerEffects/issues/4)) ([1592011](https://github.com/Heroshrine/SmokerEffects/commit/1592011b1b5d3b2117b50251e00ce66f0c40cb50))

### Effects

All effects were added in [#4](https://github.com/Heroshrine/SmokerEffects/issues/4) ([1592011](https://github.com/Heroshrine/SmokerEffects/commit/1592011b1b5d3b2117b50251e00ce66f0c40cb50)).

**Beneficial**

* **Brisk:** faster movement
* **Fervor:** faster mining
* **Might:** +1 attack damage
* **Hearty:** +1 max heart
* **Hardened:** +2 armor and armor toughness
* **Steadfast:** knockback resistance
* **Breath:** larger air supply underwater
* **Aquane:** faster swimming and underwater mining
* **Featherweight:** light as a feather
* **Sure Footed:** higher step height
* **Long Reach:** +1 block reach
* **Heat Tolerance:** less fire damage and shorter burning
* **Enderstep:** teleport away when hurt
* **Iron Stomach:** blocks harmful and neutral effects that come from eating
* **Keen Eyes:** a weaker night vision
* **Vigor:** slow regeneration
* **Sated:** slowly restores saturation, so hunger lasts longer

**Neutral**

* **Heavy:** weigh more, with knockback resistance but slightly slower movement
* **Reckless:** +2 attack damage, −4 armor
* **Unstable Enderstep:** Enderstep triggers at random

**Harmful**

* **Sluggish:** slightly slower movement
* **Brittle:** −2 armor and armor toughness
* **Affliction:** reduced healing from all sources
